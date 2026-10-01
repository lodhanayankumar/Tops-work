<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Download Song 53</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin-top: 100px;
        }
        .container {
            width: 450px;
            margin: auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
        }
        h2 {
            color: #333;
        }
        input[type="text"] {
            width: 80%;
            padding: 10px;
            margin: 15px;
        }
        input[type="submit"] {
            background-color: #333;
            color: white;
            border: none;
            padding: 10px 25px;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Download Your Song</h2>
    <form action="downloadSong53" method="get">
        <label>Enter MP3 Filename:</label>
        <br>
        <input type="text"
               name="filename"
               placeholder="Example: song.mp3"
               required>
        <br>
        <input type="submit"
               value="Download Song">
    </form>
</div>
</body>
</html>