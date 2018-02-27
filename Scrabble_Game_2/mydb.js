var mysql = require('C:\\nodejs\\node_modules\\mysql');
var util = require('util');
var curr_login;

module.exports = {
    connection: null,
    // Create a database connection
    connectDB: function () {
        var connectionConfig = {
            host: '127.0.0.1',
            port: '3306',
            user: 'root',
            password: 'Nikita_25',
            database: 'scrabbledb'
        };
        connection = mysql.createConnection(connectionConfig);
        util.log('connection::connecting...');
        connection.connect(function (err) {
            if(err)
            {
                util.log('failed'+err);
            }
            else
            {
            util.log('connection::connected');
        }
        });
    },
    
    // Add user
    insertUser: function (firstname, lastname, username, pwd, emailaddress, gender) {
        var user = {fname: firstname, lname: lastname, uname: username,pwd: pwd,email_id: emailaddress,gender:gender};
        var query = 
        connection.query('INSERT INTO register SET ?', user, function (err, results) {
            if (err)
                throw err;             
             util.log('insertUser: ' + results[0].login_id);
        });
         util.log('insertUser: ' + query.login_id);
    },
    
    //login User
    insertLoginUser: function (uname, pwd, reg_id) {
        var user = {uname: uname,pwd: pwd,reg_id:reg_id};
        connection.query('INSERT INTO login SET ?', user, function (err, results) {
            if (err)
                throw err;

            //util.log(uname + 'insertUser: ' + results.login_id);
             curr_login = results.insertId;
        });
    },
    
    //insert data
    insertData: function (pname, st_dt_tm, en_dt_tm, word, result) {
        var user = {pname: pname,st_dt_tm: st_dt_tm,en_dt_tm:en_dt_tm,word:word,result:result,login_id:curr_login};
        connection.query('INSERT INTO logs SET ?', user, function (err, results) {
            if (err)
            {
                throw err;
            }
            else
            {
            util.log('insertData: ' + results);
        }
        });
    },
    
    // Get users
    getLogData: function (res, callback) {
        connection.query('SELECT * FROM logs', function (err, rows, fields) {
            if (err)
                throw err;

            var users = [];
            rows.forEach(function (row) {
                console.log(row.pname);
                var user = {pname: row.pname, st_dt_tm: row.st_dt_tm, en_dt_tm: row.en_dt_tm,word: row.word,result: row.result};
                users.push(user);
            });

            util.log('getUsers: ' + users);
            callback(res, users);
        });
    },
       
    // Get users
    getUser: function (uname, pwd, callback){                 //res,callback1) {
        console.log("here1" + uname);
        connection.query("SELECT * FROM register WHERE uname = ?", uname, function (err, rows, fields) {
            if (err) {
                throw err;                
            }
            else if(rows.length>0)
            {
                console.log(rows[0]);
                callback(rows[0].uname,rows[0].pwd,rows[0].reg_id);
               // callback1(res, 0);
               // return 0;
              
            }
            else
            {
                console.log("length"+rows.length);
                console.log("Invalid UserName or Password..Please login with valid username & password..");
              //  callback1(res,-1);
               // return -1;
                
            }        
        });
    }

};
