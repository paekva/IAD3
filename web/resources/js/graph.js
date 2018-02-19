$(document).ready(function () {
    var x;
    var y;
    var R=0;

    R=document.getElementById("canvaForm:canvaR").value;
    if(R===null) R=0;
    drawField(R);

    //Graph
    var example = document.getElementById("example"), ctx = example.getContext('2d');

    example.addEventListener("click", drawPoint, false);

    function drawPoint(e) {
        var r = document.getElementById("canvaForm:canvaR").value;
        if(r==0.0) alert("Выберите значение радиуса!");
        else {
            var cell = getCursorPosition(e);
            ctx.beginPath();
            ctx.rect(x, y, 3, 3);
            x -= 150;
            y -= 150;
            y *= -1;
            x = x / 40;
            y = y / 40;
            ctx.fillStyle = 'gray';
            if (checkArea(x, y, r) == 1) ctx.fillStyle = 'white';
            ctx.fill();
            ctx.closePath();
            document.getElementById("canvaForm:canvaX").value = x;
            document.getElementById("canvaForm:canvaY").value = y;
            canvaReady();
        }
    }


    function getCursorPosition(e) {
        if (e.pageX !== undefined && e.pageY !== undefined) {
            x = e.pageX;
            y = e.pageY;
        } else {
            x = e.clientX + document.body.scrollLeft +
                document.documentElement.scrollLeft;
            y = e.clientY + document.body.scrollTop +
                document.documentElement.scrollTop;
        }
    }

    jsf.ajax.request(this,event,{render:'jsonData'});

});


//________FUNCTION____________________
function drawField(radius) {

    var example = document.getElementById("example"),
        ctx = example.getContext('2d');
    ctx.beginPath();
    ctx.clearRect(0,0,300,300);
    ctx.closePath();

    //Отрисовка фигуры
    ctx.beginPath();
    ctx.fillStyle = '#3BA4C7';
    ctx.fillRect(150, 150 - 40 * radius, 20 * radius, 40 * radius);
    ctx.arc(150, 150, 40 * radius, Math.PI, 1.5 * Math.PI);
    ctx.lineTo(150, 150);
    ctx.lineTo(150, 150 + 40 * radius/2);
    ctx.lineTo(150 + 40 * radius, 150);
    ctx.fill();
    ctx.closePath();

    //Отрисовка осей
    ctx.fillStyle = '#000000';
    ctx.beginPath();
    ctx.moveTo(150, 0);
    ctx.lineTo(150, 300);
    ctx.moveTo(0, 150);
    ctx.lineTo(300, 150);
    ctx.stroke();
    ctx.closePath();

    document.getElementById("canvaForm:canvaR").value = radius;
}

function checkArea(x, y, r){
    var tmp = x/2-r/2;
    var bool = y >= tmp;
    if(x >= 0 && y <= 0){
        if(bool) return 1;
        else return 0;
    } else if(x >= 0 && x <= r/2 && y < r){
        return 1;
    } else if (x <= 0 && y >= 0 && r >= Math.sqrt(y*y+x*x)){
        return 1;
    } else {
        return 0;
    }
}

function drawPoints() {
    let x = document.getElementById("mainform:xcoord").value;
    let y = document.getElementById("mainform:ycoord").value;
    let r = document.getElementById("canvaForm:canvaR").value;
    let flag = checkArea(x, y, r) === 1;
    let example = document.getElementById("example"),
        ctx = example.getContext('2d');
    ctx.beginPath();
    x = x * 40;
    y = y * 40;
    y *= -1;
    x += 150;
    y += 150;
    ctx.rect(x, y, 3, 3);
    ctx.fillStyle = 'gray';
    if (flag) ctx.fillStyle = 'white';
    ctx.fill();
    ctx.closePath();
}