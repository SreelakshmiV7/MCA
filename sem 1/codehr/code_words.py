'''
two friends exchange messages using code words , 
a-i code is 1-9
j-z code is 10#-26#
decode the message 
input - 110#-aj
'''
n=input("enter the code :")

# check if s[i+2]==#  : s[i:i+2] = val; 
new_n=""
for i  in range(len(n)):
    if n[i]=='#':
        continue
    if ((i+2)<=(len(n)-1) and n[i+2]=='#' ):
        v=n[i:i+2]
        cl=chr(int(v)+96)
        print(cl)
        new_n+=cl
        i=i+2
    else :
        v=n[i]
        cl=chr(int(v)+96)
        print(cl)
        new_n+=cl
print("original code:",n)
print("decoded code:",new_n)