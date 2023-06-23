// Use Morris.Area instead of Morris.Line
// let student_card=parseInt(document.querySelector('#student_card').value)
// let student_NoCard=parseInt(document.querySelector('#student_NoCard').value)
// let teacher_card=parseInt(document.querySelector('#teacher_card').value)
// let teacher_NoCard=parseInt(document.querySelector('#teacher_Nocard').value)

// 获取 id="student_card" 的元素
var student_card = document.getElementById("student_card");
var student_NoCard = document.getElementById("student_NoCard");
var teacher_card = document.getElementById("teacher_card");
var teacher_NoCard = document.getElementById("teacher_NoCard");
// 获取元素的内容（数值）
var studentCardValue = parseInt(student_card.innerHTML);
var studentNoCardValue = parseInt(student_NoCard.innerHTML);
var teacherCardValue = parseInt(teacher_card.innerHTML);
var teacherNoCardValue = parseInt(teacher_NoCard.innerHTML);
let value2=10;
let value3=10;
let value4=10;
Morris.Donut({
    element: 'graph-donut',
    data: [
        {value: studentCardValue, label: '学生已打卡', formatted: `${studentCardValue}人` },
        {value: studentNoCardValue, label: '学生未打卡', formatted: `${studentNoCardValue}人` },
        {value: teacherCardValue, label: '教师已打卡', formatted: `${teacherCardValue}人` },
        {value: teacherNoCardValue, label: '教师未打卡', formatted: `${teacherNoCardValue}人` }
    ],
    backgroundColor: false,
    labelColor: '#fff',
    colors: [
        '#4acacb','#6a8bc0','#5ab6df','#fe8676'
    ],
    formatter: function (x, data) { return data.formatted; }
});

var myVariable = 401;
$(function() {

    var d1 = [


    ];
    var d2 = [
        [1, studentCardValue],
        [2, studentNoCardValue],
        [3, teacherCardValue],
        [4, teacherNoCardValue],
    ];

    var data = ([{
        label: "New Visitors",
        data: d1,
        lines: {
            show: true,
            fill: true,
            fillColor: {
                colors: ["rgba(255,255,255,.4)", "rgba(183,236,240,.4)"]
            }
        }
    },
        {
            label: "Unique Visitors",
            data: d2,
            lines: {
                show: true,
                fill: true,
                fillColor: {
                    colors: ["rgba(255,255,255,.0)", "rgba(253,96,91,.7)"]
                }
            }
        }
    ]);

    var options = {
        grid: {
            backgroundColor:
            {
                colors: ["#ffffff", "#f4f4f6"]
            },
            hoverable: true,
            clickable: true,
            tickColor: "#eeeeee",
            borderWidth: 1,
            borderColor: "#eeeeee"
        },
        // Tooltip
        tooltip: true,
        tooltipOpts: {
            content: "%s X: %x Y: %y",
            shifts: {
                x: -60,
                y: 25
            },
            defaultTheme: false
        },
        legend: {
            labelBoxBorderColor: "#000000",
            container: $("#main-chart-legend"), //remove to show in the chart
            noColumns: 0
        },
        series: {
            stack: true,
            shadowSize: 0,
            highlightColor: 'rgba(000,000,000,.2)'
        },
//        lines: {
//            show: true,
//            fill: true
//
//        },
        points: {
            show: true,
            radius: 3,
            symbol: "circle"
        },
        colors: ["#5abcdf", "#ff8673"]
    };
    var plot = $.plot($("#main-chart #main-chart-container"), data, options);
});