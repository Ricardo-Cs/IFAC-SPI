from datetime import datetime

data = datetime.now().hour

if data <= 12: 
    print("Bom dia!")
elif data > 12 and data <= 18: 
    print("Boa tarde!")
else: 
    print("Boa noite!")