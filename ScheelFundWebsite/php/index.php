<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="../css/home_page.css">
</head>

<body>
    <!-- Responsive Nav Bar --> 
    <nav class="navbar visible">
        <div class="logo-title">
            <img src="../resources/corn_icon.png" alt="Scheel Fund Logo"> 
            <h1>Scheel Fund</h1> 
        </div>
        <div class="nav-items">
            <a href="../php/index.php">HOME</a>
            <a href="../php/about_page.php">ABOUT</a>
            <a href="../php/team_page.php">TEAM</a>
            <a href="../php/portfolio_page.php">PORTFOLIO</a>
            <a href="../php/contact_page.php">CONTACT</a>
        </div> 
    </nav>

    <!-- Primary Background Image -->
    <div class="background-image">
        <img class="image" src="../resources/offut.jpg" alt="Home Page Header Picture">
        <div class="overlay">
            <h2>Scheel Fund</h2>
            <h3>Offutt School of Business</h3>
        </div>
    </div>

    <!-- Body Sections --> 
    <section> 
            <img src="../resources/corn_icon.png" alt="Scheel Fund Logo">
            <div>
                <h3>Founded in 2012, the Scheel Fund is a cornerstone of Concordia’s 
                    commitment to financial education and engagement.
                </h3>
                <p>
                    Dedicated to empowering our members to navigate the complexities of the financial markets with confidence. 
                    Through participation in the fund, students gain invaluable insights into the mechanisms of investing, 
                    portfolio management, and financial decision-making.
                </p>
            </div>
    </section>

    <section class="shaded"> 
            <div>
                <h3>Our Mission</h3>
                <p>
                    The Scheel Fund aims to cultivate a deep understanding of the financial markets among students 
                    through active engagement and practical investment experience, empowering them to become knowledgeable 
                    and responsible investors.
                </p>
                <a href="../php/about_page.php" class="nav-button">About</a>
            </div>
            <img src="../resources/mission_home.jpg">
    </section> 

    <section> 
            <img src="../resources/team_home.jpg" alt="Scheel Fund Logo">
            <div>
                <h3>Student Leadership</h3>
                <p>
                    Meet our team of dedicated student leaders who are at the forefront of driving the Scheel Fund's mission. 
                    Their passion for finance and commitment to education empower our members to excel in the dynamic world 
                    of investments.
                </p>
                <a href="../php/team_page.php" class="nav-button">Our Team</a>
            </div>
    </section>

    <section class="shaded"> 
            <div>
                <h3>Contact Us</h3>
                <p>
                    Ready to join us on this journey of learning, investing, and achieving financial acumen?
                </p>
                <a href="../php/contact_page.php" class="nav-button">Contact Us</a>
            </div>
            <img src="../resources/offutt_students_working.jpg" alt="About Img">
    </section>

    <footer class="site-footer">
        <section class="footer-social">
            <a href="https://www.linkedin.com/in/grason-randall-595646226/" target="_blank" class="social-links">
                <img src="../resources/linkedin_logo.jpg" alt="LinkedIn" class="social-logos">
            </a>
            <a href="https://www.linkedin.com/in/grason-randall-595646226/" target="_blank" class="social-links">
                <img src="../resources/instagram_logo.png" alt="Instagram" class="social-logos">
            </a>
        </section>

        <div class="manager-login">
            <a href="login.php" class="manager-login-link">MANAGER LOGIN</a>
        </div>
        <div class="copyright">
            <p>© 2024 Wayne Computer Consulting Inc.</p>
        </div>
    </footer>


    <script src="main.js"></script>


</body>
</html>