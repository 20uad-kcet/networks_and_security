import socket
import sys

HOST = "localhost"
PORT = 12345
s = socket.socket(socket.AF_INET,   socket.SOCK_STREAM)
s.connect((HOST, PORT))
print(" Connected with Server")
f_send = "file_to_send.txt"
f=open(f_send, "rb") 
print("Sending file...")
data = f.read()
s.sendall(data)
s.close()
print("Disconnected")
sys.exit(0)
