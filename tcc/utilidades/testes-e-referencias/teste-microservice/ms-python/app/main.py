from fastapi import FastAPI

app = FastAPI()

@app.post("/process")
def process(data: dict):
    value = data.get("value", 0)
    return {"result": value * 2}
