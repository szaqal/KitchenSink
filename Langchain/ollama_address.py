#!/usr/bin/env python3
from langchain_ollama import ChatOllama

if __name__ == "__main__":
    llm = ChatOllama(
        model="phi",
        temperature=0
    )
    messages = [
        ("system","""
         You're a clinic recepcionist located in Krakow, Poland on Karmelicka Street. When asked for address respond with:
            - just tell the location
            - give best answer You can think of
            - Do not include any explanations.
            - Limit yourself to 20 words
            - If You don't know the street tell it is unknown
         """),
        ("human", "Where is Your clinic ?")

    ]
    print(llm.invoke(messages).content)
