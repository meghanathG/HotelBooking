
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Dashboard</title>
  <style>
    body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

header {
  background-color: #333;
  color: #fff;
  padding: 10px;
}

.navbar {
  display: flex;
  justify-content: flex-start;
}

.navbar ul {
  list-style: none;
  margin: 0;
  padding: 0;
  display: flex; /* Display the list items horizontally */
}

.navbar li {
  margin-right: 20px;
}

.navbar a {
  text-decoration: none;
  color: #fff;
  font-size: 18px;
  padding: 5px 10px;
  border-radius: 5px;
}

.navbar a:hover {
  background-color: #555;
}

main {
  padding: 20px;
}

footer {
  background-color: #333;
  color: #fff;
  padding: 10px;
  position: absolute;
  bottom: 0;
  width: 100%;
}

.dashboard {
  text-align: center;
}

.dashboard h2 {
  font-size: 24px;
  margin-bottom: 30px;
}

.cards-container {
  display: flex;
  justify-content: center;
  gap: 20px;
}

.card {
  width: 300px;
  padding: 20px;
  background-color: #f5f5f5;
  border: 1px solid #ccc;
  border-radius: 5px;
  text-align: center;
}

.card h3 {
  font-size: 20px;
  margin-bottom: 15px;
}

.card p {
  font-size: 16px;
  color: #777;
}

  </style>
</head>

<body>
  <header>
    <nav class="navbar">
      <ul>
        <li><a href="adminHome">Dashboard</a></li>
        <li><a href="viewallemps">View Employees</a></li>
        <li><a href="viewcustomers">View Customers</a></li>
        <li><a href="deleteCustomer">Delete Customers</a></li>
        <li><a href="/">Logout</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <div class="dashboard">
      <h2>Welcome to Admin Dashboard</h2>
      <div class="cards-container">
        <div class="card">
          <h3>Total Employees:</h3>
           ${ecount }
        </div>
        <div class="card">
          <h3>Total Customers:</h3>
          ${ccount }
        </div>
      </div>
    </div>
  </main>

  <footer>
    <!-- Your footer content goes here -->
  </footer>
</body>

</html>
