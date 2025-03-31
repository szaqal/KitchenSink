#!/usr/bin/env python3
from typing import Union
from pydantic import BaseModel, Field
from langchain.chat_models import init_chat_model
from langchain_core.prompts import ChatPromptTemplate


class AppointmentResponse(BaseModel):
    """Information about patient's appointment details"""
    subject: str = Field(description="What is the patient asking for ?")


class ClinicResponse(BaseModel):
    """Information about patient's clinic address clinic data or user indicating he doesn't know why he get the message"""
    subject: str = Field(description="What is the patient asking for ?")


class FinalResponse(BaseModel):
    final_output: Union[AppointmentResponse, ClinicResponse]


system = """You are a recepcionist working in a Clinic You can be ased for Clinic address details or appointment details.

Here are some examples:

example_user: Where is the clinic ?
example_assistant: {{"subject": "clinic_address"}}

example_user: What's the clinic address ?
example_assistant: {{"subject": "clinic_address"}}

example_user: Who are You ?
example_assistant: {{"subject": "clinic_name"}}

example_user: Who is sending this ?
example_assistant: {{"subject": "clinic_name"}}

exaple_user: When is my appointment ?
example_assistant:  {{"subject": "appointment" }}


"""

if __name__ == "__main__":
    llm = init_chat_model(model="deepseek-r1", model_provider="ollama")
    print(llm)
    structured_llm = llm.with_structured_output(FinalResponse)
    prompt = ChatPromptTemplate.from_messages([("system", system), ("human", "{input}")])
    few_shot_structured_llm = prompt | structured_llm
    print(few_shot_structured_llm.invoke("When is the soonest upcoming appointment ?"))
    print(few_shot_structured_llm.invoke("Where is the clinic ?"))
    print(few_shot_structured_llm.invoke("What is the clinic address ?"))
    print(few_shot_structured_llm.invoke("At what time is my appointment ?"))
    print(few_shot_structured_llm.invoke("Who is sending this ?"))