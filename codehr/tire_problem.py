'''
an automobile company many factures 2 wheeler and 4 wheelers according to the given data 
-total number of vehicles
-total number of wheels 
how many 2 wheelers and 4 wheelers are possible 
'''
def wrongmethod():
    v=int(input("enter the no of vehicle:"))
    w=int(input("enter the number of wheels :"))
    for i in range (w):
        for j in range(w):
            if (((i*2)+(j*4))==w and i+j==v):
                print("number of 2 wheelers:",i)
                print("number of 4 wheelers:",j)
                break
wrongmethod()
def correctmmethod(w,v):
    f=w//2-v
    t=v-f
    return(list((t,f)))

print(correctmmethod(540,200))
