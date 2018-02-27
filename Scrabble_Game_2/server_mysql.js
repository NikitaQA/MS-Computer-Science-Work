/* 
 * Student Info: Name=Nikita Vilas Patil, ID=12541
 * Subject: CS557B_HW3_Summer_2015
 * Author: Milind
 * Filename: server_mysql.js
 * Date and Time: Jul 27, 2015 9:23:19 PM
 * Project Name: CS557B_HW3_Nikita_Patil_12541
 */


//replace port 8080 below if you wish to change the server port
var serverport = 8080;

var http = require('http');
var qs = require('querystring');
var url = require('url');
var fs = require('fs');
var util = require('util');
var mime = require('C:\\nodejs\\node_modules\\mime');
var vidStreamer = require("C:\\nodejs\\node_modules\\vid-streamer");

var mydb = require('./mydb');

//write back result
writeResult = function (res, code, result, mimetype) {
    res.writeHead(code, {'Content-Type': mimetype, 'Content-Length': result.length});
    res.write(result);
    res.end();
}

// get getFilename from request using url
getFilename = function (req) {
    var filename = req.url.substring(1);
    if (!!filename)
        return filename;
    return "/";
}

// sendFile 
sendFile = function (filename, res) {
    if (filename[filename.length - 1] === '/')
        filename += 'index.html'    ;
    fs.readFile(filename, function (err, data) {
        if (err) {
            writeResult(res, "404", "Page not found!", "text/plain");
            return;
        }
//    console.log('file: ' + filename + ' mime : ' + mime.lookup(filename));    
        writeResult(res, 200, data, mime.lookup(filename));
    });
}

 /*errorFunc = function(res,ret)
    {
        if(ret == -1)
        {
            res.writeHead(301,{Location: 'http://localhost:8080/login.html'}); 
        }
        else
        {
            res.writeHead(301,{Location: 'http://localhost:8080/games.html'});
        }
    }*/

// the GET handler
handleGet = function (req, res) {
    var filename = getFilename(req).replace(/%20/g, " ");

    if (req.url === "/") {
        writeResult(res, "200", "A Simple Server says: Hello!", "text/plain");
    }
    else if (req.url === "/delay") {
        setTimeout(function () {
            sendFile('dummypage', res);
        }, 2000);
    }
    else if (req.url === '/getLogData') {
        mydb.getLogData(res, getData);
    }
   /* else if (req.url === '/getLogin') {
        mydb.getLogin(res, getData);
    }*/
    else {
        console.log(filename);
        sendFile("..\\"+filename, res);
    }
}

//Handles /postAddUser
addUser = function (req, res) {
    var body = "";
    req.on('data', function (data) {
        body += data;
    });
    req.on('end', function () {
        var obj = qs.parse(body);
        mydb.insertUser(obj.fn, obj.ln, obj.un, obj.pw, obj.em, obj.gender);   
        res.writeHead(301,{Location: 'http://localhost:8080/register.html'});
        res.end();
    });
};

//Add Login User
addLoginUser = function (req, res) {
    var body = "";
    req.on('data', function (data) {
        body += data;
    });
    req.on('end', function () {
        var obj = qs.parse(body);
        console.log("user"+ obj.un);
        mydb.getUser(obj.un, obj.pw,mydb.insertLoginUser); //var ret= mydb.getUser(.....res,,mydb.errorFunc);        
        res.writeHead(301,{Location: 'http://localhost:8080/games.html'});
        res.end();
    });
};

//Add game data
addData = function (req, res) {
    var body = "";
    req.on('data', function (data) {
        body += data;
    });
    req.on('end', function () {
        var obj = qs.parse(body);
        console.log("login user....."+ obj.pname+obj.st_dt_tm+obj.en_dt_tm+obj.word+obj.result);
        mydb.insertData(obj.pname,obj.st_dt_tm,obj.en_dt_tm,obj.word,obj.result);   
        res.end();
    });
};

// HTTP REQUEST HANDLERS
handlePost = function (req, res) {
    if (req.url === "/postComment") {
        addComment(req, res);
    } else if (req.url === "/postRegUser") {
        addUser(req, res);
    } 
    else if (req.url === "/postLoginUser") {
        addLoginUser(req, res);
    }
    else if (req.url === "/postGameData") {
        addData(req, res);
    }else {
        var str = "<h1>Server Response</h1>"
                + "Your post was successful!";
        writeResult(res, "200", str, "text/html");
    }
};

getData = function (res, users) {
    var content =  JSON.stringify(users);
    res.end(content);
};

getUser = function (res, users) {
    //util.log("INCOMING REQUEST: " + req.method + " " + req.url);
    res.writeHead(200, {"Content-Type": "text/html"});
    var content = JSON.stringify(users);
    res.end(content);
    util.log(content);
};

// Connect to DB first
mydb.connectDB();

// server starts here
http.createServer(function (req, res) {
    if (req.method === 'GET') {
        handleGet(req, res);
    }
    else
    if (req.method === 'POST') {
        handlePost(req, res);
    }
}).listen(serverport);
util.log('A Simple Node Server is running...');


