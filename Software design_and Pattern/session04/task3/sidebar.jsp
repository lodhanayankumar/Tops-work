<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidebar">

    <h2>Admin Panel</h2>

    <a href="${pageContext.request.contextPath}/dashboard">
        Dashboard
    </a>

    <a href="${pageContext.request.contextPath}/orders">
        Orders
    </a>

    <a href="${pageContext.request.contextPath}/profile">
        Profile
    </a>

</div>

<style>
    .sidebar {
        width: 220px;
        height: 100vh;
        background-color: #222;
        padding: 20px;
        position: fixed;
        left: 0;
        top: 0;
    }

    .sidebar h2 {
        color: white;
        text-align: center;
        margin-bottom: 30px;
    }

    .sidebar a {
        display: block;
        color: white;
        text-decoration: none;
        padding: 15px;
        margin-bottom: 10px;
        background-color: #333;
    }

    .sidebar a:hover {
        background-color: #555;
    }

    .content {
        margin-left: 260px;
        padding: 30px;
    }
</style>