// const fs = require("fs");
// const text = fs.readFileSync("./txtFiles/input.txt","utf-8");
// console.log(123)
// console.log(text);
const http =require("http");
const express = require("express")
const app = 
const server = http.createServer((req,res)=>{
    console.log(req);
    res.end("Hello MineWorld");
});
server.listen(8000,"127.0.0.1",() => {
    console.log("Listening to request");
});