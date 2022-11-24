#chat client

import socket,time 
host="127.0.0.1"
port=65432
with socket.socket(socket.AF_INET,socket.SOCK_STREAM) as s:
      s.connect((host,port))
      while True:
            msg=s.recv(1024)
            msg=msg.decode()
            print("server : ",msg)
            msg=input(str("ME : "))
            if msg=="end":
                  break
            s.sendall(msg.encode())
      
