#!/usr/bin/env python3
from typing import Optional
from pydantic import BaseModel, Field
from langchain.chat_models import init_chat_model

class Response(BaseModel):
    planet: str = Field(description="What planet user is asking for")



if __name__ == "__main__":
    llm = init_chat_model(model="deepseek-r1", model_provider="ollama")
    print(llm)
    structured_llm = llm.with_structured_output(Response)
    print(structured_llm.invoke("Tell me something about mercury planet"))