"use strict";
//selector//
let names=document.querySelector("name")
let cost=document.querySelector("cost")
let damagetype=document.querySelector("dt")
let dice=document.querySelector("dice")
let property=document.querySelector("prop")

let createbtn=document.querySelector('#createbtn')
let updatebtn=document.querySelector('#updatebtn')
let delbtn=document.querySelector('#delbtn')
//get all
let getAll =()=>{
    axios.get("http://localhost:8080/getall")
    .then(res =>{
        console.log(res.data);
    }).catch(err=> console.log(err));
}
//create
let create =()=>{

    let obj ={
        "cost":cost,
        "damagetype":damagetype,
        "dice":dice,
        "name":names,
        "propeties":property
    }
    axios.post("http://localhost:8080/create")
    .then(res =>{
        console.log(res.data);
    }).catch(err=> console.log(err));
}
//update
let update =()=>{
    axios.put("http://localhost:8080/update")
    .then(res =>{
        console.log(res.data);
    }).catch(err=> console.log(err));
}
//delete
let del =()=>{
    axios.delete("http://localhost:8080/delete")
    .then(res =>{
        console.log(res.data);
    }).catch(err=> console.log(err));
}

createbtn.addEventListener("click",create);
updatebtn.addEventListener("click",update);
delbtn.addEventListener("click",del);