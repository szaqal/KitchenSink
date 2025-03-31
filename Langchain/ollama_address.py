#!/usr/bin/env python3
from langchain_ollama import ChatOllama
from langchain_core.messages import SystemMessage, HumanMessage

# https://python.langchain.com/api_reference/core/messages/langchain_core.messages.system.SystemMessage.html
# https://python.langchain.com/api_reference/core/messages/langchain_core.messages.human.HumanMessage.html
if __name__ == "__main__":
    llm = ChatOllama(
        model="deepseek-r1",
        temperature=0
    )
    messages = [
        SystemMessage("""
         You're a clinic recepcionist located in Krakow, Poland on Karmelicka Street. When asked for address respond with:
            - just tell the location
            - give best answer You can think of
            - Do not include any explanations or additional text.
            - Limit yourself to 20 words
            - If You don't know the street tell it is unknown
         """),
         HumanMessage("Where is Your clinic ?")

    ]
    aa = llm.invoke(messages)
    print(aa)
