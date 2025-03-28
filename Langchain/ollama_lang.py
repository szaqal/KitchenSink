#!/usr/bin/env python3
from langchain_core.prompts import ChatPromptTemplate
from langchain_ollama.llms import OllamaLLM

def main():
    """
    The main function of the application.

    This function is the entry point of the application.
    """
    print("Hello, World!")

if __name__ == "__main__":
    template = """Question: {question} Answer: Let's think step by step."""
    prompt = ChatPromptTemplate.from_template(template)
    model = OllamaLLM(model="deepseek-r1:8b")
    chain = prompt | model
    print(chain.invoke({"question": "What is LangChain?"}))