<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
    <style>
        table, tr, td, th{
            border : 1px solid black;
            border-collapse: collapse;
            padding : 5px 10px;
            text-align: center;
        }
        th{
            background-color: beige;
        }
        tr:nth-child(even){
            background-color: azure;
        }
    </style>
</head>
<body>
    <div id="app">
        <!-- html 코드는 id가 app인 태그 안에서 작업 -->
         <div id="container">
            <div>
                <label>번호:<input v-model="profNo"></label> 
            </div>

            <div>
                <label>이름:<input v-model="Name"></label> 
            </div>



            <label>포지션:
             <select v-model="position" @change="fnGetList">
                        <option value="">:: 전체 ::</option>
                        <option value="정교수">정교수</option>
                        <option value="조교수">조교수</option>
                        <option value="전임강사">전임강사</option>
                        </select>
                        </label>
                 <div>
                    <label>급여<input v-model="pay"  </label>
                 </div>
                    <label>
                        학과 : 
                    <select v-model="deptNo" >
                        <option value="">::전체::</option>
                         <option v-for="item in deptList" :value="item.deptNo">{{item.dName}}</option>
                    </select>
                    
                </label>
                </div>
                <div>
                    <button @click="fnProfadd">교수추가</button>
                </div>
    </div>
</body>
</html>

<script>
    const app = Vue.createApp({
        data() {
            return {
                // 변수 - (key : value)
                deptList:[],
                profNo:" ",
                Name:"",
                position:"",
                deptNo:"",
                pay:""                
            };
        },
        methods: {
            // 함수(메소드) - (key : function())
            fnProfadd: function () {
                let self = this;
                let param = {
                    profNo:self.profNo,
                    Name:self.Name,
                    position:self.position,
                    pay:self.pay,
                    deptNo:self.deptNo
                };
                $.ajax({
                    url: "http://localhost:8080/prof/add.dox",
                    dataType: "json",
                    type: "POST",
                    data: param,
                    success: function (data) {
                        alert(data.message);
                        if(data.result=='success'){
                            location.href="/prof-list.do"

                    }
                }
                });
            },

             fnDeptList: function () {
                let self = this;
                let param = {};
                $.ajax({
                    url: "http://localhost:8080/dept/list.do",
                    dataType: "json",
                    type: "POST",
                    data: param,
                    success: function (data) {
                        self.deptList=data.list;
                        self.deptNo=data.list[0].deptNo

                    }
                });
            }
        }, // methods
        mounted() {
            // 처음 시작할 때 실행되는 부분
            let self = this;
        }
    });

    app.mount('#app');
</script>