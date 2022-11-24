import socket
import sys
HOST = "localhost"
PORT = 12345
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST, PORT))
s.listen(5)
print("Listening ...")
conn, addr = s.accept()
print(" Client connected: ", addr)
f = open("file_received.txt", "wb")
while True:
    data = conn.recv(4096)
    if not data:
        break
    f.write(data)
f.close()
print("Download complete!")
conn.close()
print("Client disconnected")
sys.exit(0)