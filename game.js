var board = [ [ 9,9,9,9,9,9,9,9,9,9,9],
              [ 9,0,0,0,0,0,0,0,0,0,0],
              [ 9,0,0,0,0,0,0,0,0,0,0],
              [ 9,0,0,0,0,0,0,0,0,0,0],
              [ 9,0,0,0,0,0,0,0,0,0,0],
              [ 9,0,0,0,0,0,0,0,0,0,0],
              [ 9,0,0,0,0,0,0,0,0,0,0],
              [ 9,0,0,0,0,0,0,0,0,0,0],
              [ 9,0,0,0,0,0,0,0,0,0,0],              
              [ 9,0,0,0,0,0,0,0,0,0,0],
              [ 9,0,0,0,0,0,0,0,0,0,0] ];

function gameInitial() { 
    var myTable = document.getElementById("boardTable");    
    for (let i = 1; i <=10 ; i++) {
        for (let j = 1; j <= 10 ; j++) {    
                myTable.rows[i].cells[j].innerHTML = "";  //reset HTML table
                board[i][j]=0;                            //reset board array of javaScript
        }
    }

    for (let index = 0; index < 3; index++) {        
        var shipRowLocation = (Math.floor(Math.random()*6 )) + 1; //random location btw 1 and 6
        var shipColumnLocation = (Math.floor(Math.random()*6 )) + 1; //random location btw 1 and 6
        var horiOrVerti =  (Math.floor(Math.random()*2)) ; //random 0 for horizontal and 1 for vertical

        for (let index2 = 0; index2 < 5; index2++) {
            if(horiOrVerti == 0){
                board[shipRowLocation][shipColumnLocation+index2] = 1; //ship lays on horizontal
            }else{
                board[shipRowLocation+index2][shipColumnLocation] = 1; //ship stands on vertical
            }            
        }        
    }
}

function play() {
    var userRow = document.getElementById("rowChosen").value;
    var userColumn = document.getElementById("columnChosen").value;
    var myTable = document.getElementById("boardTable");
    if (board[userRow][userColumn] == 1){
        document.getElementById("hitOrMiss").value = "HIT!";
        myTable.rows[userRow].cells[userColumn].innerHTML = 1;
        myTable.rows[userRow].cells[userColumn].style.backgroundColor="green";
    }else{
        document.getElementById("hitOrMiss").value = "MISS!";
        myTable.rows[userRow].cells[userColumn].innerHTML = -1;
        myTable.rows[userRow].cells[userColumn].style.backgroundColor="red";
    }
}

function showAnswer() {
    var myTable = document.getElementById("boardTable");    
    for (let i = 1; i <=10 ; i++) {
        for (let j = 1; j <= 10 ; j++) {
            if( board[i][j]!=0){
                myTable.rows[i].cells[j].innerHTML = board[i][j];
            }
            
        }
    }
}