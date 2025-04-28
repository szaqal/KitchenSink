#!/usr/bin/env python3
from typing import Union
from pydantic import BaseModel, Field
from langchain.chat_models import init_chat_model
from langchain_core.prompts import ChatPromptTemplate


class Response(BaseModel):
    """Information about patient's appointment details"""
    subject: str = Field(description="What is the patient asking for ?")
    tags: list[str] = Field(description="Extract tags")
    sentiment: str = Field(description="Sentiment")
    entities: list[str] = Field(description="Entity being referred")



system = """You are a automated receptionist system working in a Clinic You can be asked for clinic, appointment data for asked to do certain actions
Patients can ask about number of things like:
* Always assume that patient is contacting you
* Patients can have multiple scheuled or cancelled appointments
* Clinic address clinic_address
* Appointment details like time and date (appointment_time), doctor name location (appointment_location)
* Patient can ask for personel action and that should be classified as personel_action which can be 
* When possible extract sentiment put it into sentiment field and bucketize into "positive", "negative", "netural" oprimize for accuracy over recall
* When extracting tags that may be relevant for personel actions like data modificatio, removal, contact request but also if it's request extract entity one is asking for
* Extract entity which can one of appointment, clinic 

Here are some examples:

user: Where is the clinic ?
assistant: {{"subject": "clinic_address", "tags":["clinic", "address", "request"], "sentiment":"neutral", "entities":["clinic"]}}

user: What's the clinic address ?
assistant: {{"subject": "clinic_address", "tags":["clinic", "address", "request"], "sentiment":"neutral", "entities":["clinic"]}}

user: Who are You ?
assistant: {{"subject": "clinic_name", "tags":["clinic", "request"], "sentiment":"neutral", "entities":["clinic"]}}

user: Who is sending this ?
assistant: {{"subject": "clinic_name", "entities":["clinic"]}}

user: When is my appointment ?
assistant:  {{"subject": "appointment_time", "entities":["appointment"]}}

user: Where is my appointment ?
assistant:  {{"subject": "appointment_location", "entities":["appointment"] }}

user: STOP!!
assistant:  {{"subject": "personel_action", "entities":[] }}

user: Cancel my appointment
assistant:  {{"subject": "personel_action", "entities":["appointment"] }}

user: I want it to be reschedule
assistant:  {{"subject": "personel_action", "entities":["appointment"] }}

user: Call me back 
assistant:  {{"subject": "personel_action", "entities":[] }}

"""

GREEN = '\033[32m'
RESET = '\033[0m'
YELLOW = '\033[33m'

def classify(llm, query):
    print("-"*100)
    print(f'{GREEN}>>>MO: {query}{RESET}')
    llm_result = llm.invoke({"input": query})

    if llm_result.subject == "next_upcoming_appointment" or llm_result.subject == "next_upcoming_appointment_time":
        print("\tSYSTEM: db lookup for soonest appointent")
        print(f"{YELLOW}<<<MT: Your next appt is on blah blah{RESET}")
    if llm_result.subject == "appointment_time":
        print("\tSYSTEM: attempt to query based on available metadata extracted from LLM")
        print(f"{YELLOW}<<<MT: Your appt is on blah blah at blah blah{RESET}")
    if llm_result.subject == "number_of_appointments_next_week" or llm_result.subject == "scheduled_visits":
        print("\tSYSTEM: db lookup for appointents next week")
        print(f"{YELLOW}<<<MT: Your appts next week are 1.., 2.. 3, ..{RESET}")
    if llm_result.subject == "clinic_address" or llm_result.subject == "clinic_name":
        print("\tSYSTEM: db lookup  for Clinic name and address")
        print(f"{YELLOW}<<<MT: Our address is ......{RESET}")
    if llm_result.subject == "personel_action" or llm_result.subject == "data_modification":
        print("\tSYSTEM: Bucketize and Triage request and notify personel (whatever the channel)")
        print(f"{YELLOW}<<<MT: Our personel will contact You sooni{RESET}") 

    print(f'\n Details: WHAT? {llm_result.subject} TAGS: {llm_result.tags} SENTIMENT:{llm_result.sentiment} ENTITIES: {llm_result.entities}')

    

if __name__ == "__main__":
    llm = init_chat_model(model="deepseek-r1", model_provider="ollama")
    print(llm)
    structured_llm = llm.with_structured_output(Response)
    prompt = ChatPromptTemplate.from_messages([("system", system), ("human", "{input}")])
    few_shot_structured_llm = prompt | structured_llm

    classify(few_shot_structured_llm, "When is my next upcoming appointment?")
    classify(few_shot_structured_llm, "At what time is my appt on 15th Nov?")
    classify(few_shot_structured_llm, "How many vists do I have sheduled next week?")
    classify(few_shot_structured_llm, "Where is the clinic ?")
    classify(few_shot_structured_llm, "How can I find a clinic ?")
    classify(few_shot_structured_llm, "What is the clinic address ?")
    classify(few_shot_structured_llm, "Who is sending this ?")
    classify(few_shot_structured_llm, "At what time is my appointment ?")
    classify(few_shot_structured_llm, "What time I should be there ?")
    classify(few_shot_structured_llm, "Please reschedule my appointent")
    classify(few_shot_structured_llm, "Go and cancel my appointment")
    classify(few_shot_structured_llm, "Delete all my data")
    classify(few_shot_structured_llm, "Cancel all my appointments please!")
    classify(few_shot_structured_llm, "Can anybody call me")
    classify(few_shot_structured_llm, "Contact me please")
    classify(few_shot_structured_llm, "Contact me URGENTLY")
    classify(few_shot_structured_llm, "I don't want to receive messages anymore")
    classify(few_shot_structured_llm, "Stop sending me messages")

