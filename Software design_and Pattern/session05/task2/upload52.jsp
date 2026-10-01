<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <title>Song Upload 52</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin-top: 80px;
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

        input {
            margin: 10px;
            padding: 8px;
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

    <h2>Upload Favorite Song</h2>

    <form action="uploadSong52"
          method="post"
          enctype="multipart/form-data">

        <label>Username:</label>

        <br>

        <input type="text"
               name="username"
               placeholder="Enter username"
               required>

        <br>

        <label>Select MP3 Song:</label>

        <br>

        <input type="file"
               name="song"
               accept=".mp3"
               required>

        <br><br>

        <input type="submit"
               value="Upload Song">

    </form>

</div>

</body>

</html>