import time
from ipynb.fs.full.sahilnew import randomforest
from firebase import firebase
import re
import numpy as np
input_set=[]
firebase=firebase.FirebaseApplication('https://skitcollege-b3f17.firebaseio.com/',None)

while True:
    print('.',end="")
    result=firebase.get('/requestTable',None)
    if result is None:
        time.sleep(3)
    else:
            tu=tuple(result.items())

        #for i in range(len(tu)):
            request_dict=tuple(tu[0][1].items())
            #print(request_dict[0][1])
            #print(request_dict[1][1])
            #print(request_dict[2][1])
            #print(request_dict[3][1])
            #print(request_dict[4][1])
    
            if request_dict[1][1]=='0':
                input_set_raw=request_dict[0][1]
                for items in request_dict[2][1]:
                    input_set_raw.append(items)
                print(input_set_raw)
                
                input_set=[]
                for item in input_set_raw:
                    m = re.search(r'\d+$', item)
                    input_set.append(int(m.group()) if m else None)
                input_set=np.atleast_2d(input_set)
                print(input_set)
#function call of ML
                ans=randomforest(input_set)
                #5print(ans)
                result=firebase.put('ResponceTable/'+str(request_dict[4][1]),'Ans',str(ans[0]))
                result=firebase.delete('requestTable',str(request_dict[4][1]))
                #print (type(str(tu[2][1])))  
            else:
                continue
