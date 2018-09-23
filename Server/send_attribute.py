from firebase import firebase
firebase=firebase.FirebaseApplication('https://skitcollege-b3f17.firebaseio.com/',None)

a=['bathroom','deposit','property_size','bedroomtotal','balconies','total_floor']  

result=firebase.put('AttributeTable/','attr',a)

print("aa")
