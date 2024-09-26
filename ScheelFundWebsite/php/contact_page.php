<!DOCTYPE html>
<?php
session_start();
?>
<script>
    if ($_SESSION['mail_sent']=1) {
        alert('Thank you for your inquery. We will be in contact soon!')
        $_SESSION['mail_sent']=0;
    }
</script>
<?php
// THE GENERAL FORMAT WAS GENERATED FROM A CHATGPT QUESTION

    $_SESSION['name_error'];
    $_SESSION['email_error'];
    $_SESSION['message_error'];
    // Check if the form is submitted
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $name = $_POST['name'];
    $email = $_POST['email'];
    $message = $_POST['message'];

    if (isset($_POST['submitMainForm'])) {
    // Check if the field is empty
    if (empty($name)) {
        // Set an error session variable
        $_SESSION['fNameIn_error'] = true;
    }
    else {
        unset($_SESSION['name_error']);
    } 
    if (empty($email)) {
        // Set an error session variable
        $_SESSION['email_error'] = true;
    }
    else {
        unset($_SESSION['email_error']);
    }
    if (empty($message)) {
        // Set an error session variable
        $_SESSION['message_error'] = true;
    }
    else {
        unset($_SESSION['message_error']);
    }

    if(!isset($_SESSION['name_error']) && !isset($_SESSION['email_error']) && !isset($_SESSION['message_error']))
    {
        session_unset();
        session_destroy();
        header("Location: email.php");
        exit;
    } 
    }
    else {
        session_unset();
        session_destroy();
    }
}
//THIS MAYBE COULD BE REMOVED BUT I LEFT IT IN BECAUSE IT GOT LATE AT NIGHT
else {
    session_unset();
    session_destroy();
}
?>
<html>
    <head>
        <title>Contact Form</title>
        <link rel="stylesheet" href="../css/contact_page.css">
        <script type="text/javascript">
            function ValidateForm() {

                var isValid = true;
                var requiredFields = ["name", "email", "message"]
                var requiredFieldsLabels = ["name", "emailLabel", "messageLabel"]
                
                for (var i=0; i<requiredFields.length; i++) {
                    document.getElementById(requiredFieldsLabels[i]).className = "";

                    if(document.forms["mainForm"][requiredFields[i]].value == "") {
                        alert("ERROR: Please fill out all required fields.") 
                        document.getElementById(requiredFieldsLabels[i]).className = "error";
                        isValid = false; 
                        break; 
                    }
                }
                if(document.forms["mainForm"][requiredFields[0]].value != "" && document.forms["mainForm"][requiredFields[1]].value != "" 
                && document.forms["mainForm"][requiredFields[2]].value != "") {
                    alert('Thank you for your inquery. We will be in contact soon!');
                    
                }
                document.getElementById('mainForm').action="email.php";
                return isValid;
            
            }
        </script>
    </head>
    <body>
        <header>
            <div class="logo-header"> 
                <img class="logo-header" src="../resources/scheelFundCorn2.gif" alt="Scheel Fund Logo">
                <h1>Scheel Fund</h1>
            </div>
            <nav>
                <a href="../php/index.php">HOME</a>
                <a href="../php/about_page.php">ABOUT</a>
                <a href="../php/team_page.php">TEAM</a>
                <a href="../php/portfolio_page.php">PORTFOLIO</a>
                <a href="../php/contact_page.php">CONTACT</a>
            </nav>
        </header>
        <div class="form">
            <p class="section_header"> Contact Us </p>
            <p class="section_description"> Ready to take the next step and join the Scheel Fund? Complete the form and we will get in touch with you as soon as possible.</p>
            <p class="required"> * Denotes Required Field</p>
            <form id="mainForm" name="mainForm" method="post" action="" enctype="multipart/form-data" onsubmit="return ValidateForm();">

                <label id="nameLabel" name="nameLabel" for="name" class="<?php echo isset($_SESSION['name_error']) ? 'error' : '';?>" >* Name:</label>
                <input type="text" id="name" name="name" value="<?php echo $_POST['name']?>"/><br />

                <label id="emailLabel" name="emailLabel" for="email" class="<?php echo isset($_SESSION['email_error']) ? 'error' : '';  ?>" >* Email: </label>                    
                <input type="email" id="email" name="email" value="<?php echo $_POST['email']?>"/><br /> 

                <label id="messageLabel" name="messageLabel" for="message" class="<?php echo isset($_SESSION['message_error']) ? 'error' : '';  ?>">* Message: </label>
                <input type="text" id="message" name="message" value="<?php echo $_POST['message']?>"/><br />

                <label id="submitLabel" name="submitLabel" for="submitContactForm">&nbsp;</label>
                <input type="submit" id="submitMainForm" name="submitMainForm" />

            </form>
        </div>
        <footer>
            <p class="college">Concordia College</p><br />
            <p class="address">901 8th St S, Moorhead, Minnesota 56562</p>
            <nav>
                <a href="login.php" class="manager-LOGIN-link" >Manager Login</a>
            </nav>
    </footer>
    </body>
        
    
</html>