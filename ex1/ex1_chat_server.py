#chat server

import socket,time 
host="127.0.0.1"
port=65432
with socket.socket(socket.AF_INET,socket.SOCK_STREAM) as s:
      s.bind((host,port))
      s.listen()
      conn,addr=s.accept()
      with conn:
            while True:
                  msg=input(str("ME : "))
                  if msg=="end":
                        break
                  conn.sendall(msg.encode())
                  msg=conn.recv(1024)
                  msg=msg.decode()
                  print("client : ",msg)
