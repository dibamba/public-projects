 this is simple app demonstrating the RAG(Retrieval-augmented generation) in agentic chatbot app called studypal.

 it uses pdf chapters for biology(used only for this demo) and other subjects.

 takes help of ollama LLM and rag to respond to the class12 reader queries.
 It creates chroma vector db of the pdf chapter files.

 Takes the user query and uses rag against the generated vector db and queries llm for response.

 also creates top 3 YouTube links related to user query and adds that to response.

 Steps:
 1. Start your local ollama and pull the model gemma2:2b. And run that model.
 My code is hard-coding to use this model only for desktop space constraint.

 1a. Also create your grow api key and add it to .env file param. Needed to use local Ollama llm.

 2. generate the vector db for the files in data folder. for this demo i use 2 chapters from biology.
 for more chapters more folders has to be created in similar hierarchy.
 the code reads the subject chapters from folder path specified in .env file which is application copy
 of env_template.txt in src folder.
 executing src/vectorize_script.py will create 2 vector_db colders as below.
 chapters_vector_db/
 vector_db

 3. then executing the streamlit app with script src/main.py will start the local app as specified in the app_screenshot file.


