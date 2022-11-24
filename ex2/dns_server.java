//DNS server
import java.io.*;
import java.net.*;
public class dnsserver
{
private static int indexOf(String[] array, String str)
{
str = str.trim();
for (int i=0; i < array.length; i++)
{
if (array[i].equals(str)) return i;
}
return -1;
}
public static void main(String arg[])throws IOException
{
String[] hosts = {"zoho.com", "gmail.com","google.com", "facebook.com"};
String[] ip = {"172.28.251.59", "172.217.11.5","172.217.11.14",
"31.13.71.36"}; System.out.println("Press Ctrl + C to Quit");
while (true)
{
DatagramSocket serversocket=new DatagramSocket(1362);
byte[] senddata = new byte[1021];
byte[] receivedata = new byte[1021];
DatagramPacket recvpack = new DatagramPacket(receivedata,
receivedata.length);
serversocket.receive(recvpack);
String sen = new String(recvpack.getData());
InetAddress ipaddress = recvpack.getAddress();
int port = recvpack.getPort();
String capsent;
System.out.println("Request for host " + sen);
if(indexOf (hosts, sen) != -1)
capsent = ip[indexOf (hosts, sen)];
else
capsent = "Host Not Found"; senddata = capsent.getBytes();
DatagramPacket pack = new DatagramPacket (senddata,
senddata.length,ipaddress,port);
serversocket.send(pack);
serversocket.close();
}
}
}

