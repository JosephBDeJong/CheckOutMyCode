<?php
// Start the session
session_start();

// Assign session variable to a JavaScript variable
echo '<script>';
echo 'var permission = "' . $_SESSION['permission'] . '";';
echo '</script>';
//var_dump($_SESSION);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio Page</title>
    <link rel="stylesheet" href="../css/portfolio_page.css">
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

    
  
    
      <div class="container">
        
        <div class="growthPortfolio">
        <div class="header-buttons">
          <h1> Growth Portfolio </h1>
          <button class="buy-button">Buy</button>
          <button class="sell-button">Sell</button>
        </div>
          <!-- Growth Portfolio Widget -->
          <!-- TradingView Widget BEGIN -->
          <div class="tradingview-widget-container">
            <div class="tradingview-widget-container__widget"></div>
            <script type="text/javascript" src="https://s3.tradingview.com/external-embedding/embed-widget-market-quotes.js" async>
            {
            "width": "100%",
            "height": "700",
            "symbolsGroups": [
              {
                "name": "Growth Portfolio",
                "originalName": "Forex",
                "symbols": [
                  {
                    "name": "NASDAQ:GOOGL",
                    "displayName": "Alphabet Inc."
                  },
                  {
                    "name": "NASDAQ:AMZN",
                    "displayName": "Amazon Inc."
                  },
                  {
                    "name": "NYSE:AMN",
                    "displayName": "AMN Healthcare Services Inc."
                  },
                  {
                    "name": "NASDAQ:AAPL",
                    "displayName": "Apple Inc."
                  },
                  {
                    "name": "NASDAQ:AMAT",
                    "displayName": "Applied Materials Inc."
                  },
                  {
                    "name": "NASDAQ:TECH",
                    "displayName": "Bio-Techne Corporation"
                  },
                  {
                    "name": "NYSE:CRC",
                    "displayName": "California Resources Corporation"
                  },
                  {
                    "name": "NYSE:CHGG",
                    "displayName": "Chegg Inc."
                  },
                  {
                    "name": "NASDAQ:CRWD",
                    "displayName": "Crowdstrike Holdings Inc."
                  },
                  {
                    "name": "NYSE:DAL",
                    "displayName": "Delta Air Lines"
                  },
                  {
                    "name": "NASDAQ:ENPH",
                    "displayName": "Enphase Energy"
                  },
                  {
                    "name": "NYSE:GD",
                    "displayName": "General Dynamics Corporation"
                  },
                  {
                    "name": "NYSE:ICE",
                    "displayName": "Intercontinental Exchange Inc."
                  },
                  {
                    "name": "NYSE:JLL",
                    "displayName": "Jones Lang Lasalle Inc."
                  },
                  {
                    "name": "NYSE:LAAC",
                    "displayName": "Lithium Americas (Argentina) Corp"
                  },
                  {
                    "name": "NYSE:LAC",
                    "displayName": "Lithium Americas Corp"
                  },
                  {
                    "name": "NASDAQ:MSFT",
                    "displayName": "Microsoft Corporation"
                  },
                  {
                    "name": "NYSE:OMF",
                    "displayName": "OneMain Holdings Inc."
                  },
                  {
                    "name": "NASDAQ:PANW",
                    "displayName": "Palo Alto Networks Inc."
                  },
                  {
                    "name": "CAPITALCOM:PLD",
                    "displayName": "Prologis Inc."
                  },
                  {
                    "name": "NYSE:RSG",
                    "displayName": "Republic Services Inc."
                  },
                  {
                    "name": "NYSE:RTX",
                    "displayName": "RTX Corporation"
                  },
                  {
                    "name": "NYSE:NOVA",
                    "displayName": "Sunnova Energy International Inc."
                  }
                ]
              }
            ],
            "showSymbolLogo": true,
            "colorTheme": "light",
            "isTransparent": false,
            "locale": "en"
          }
            </script>
          </div>
          <!-- TradingView Widget END -->
        </div>
    
        <div class="economicCalendar">
          <h1> Economic Calendar </h1>
          <!-- Economic Calendar Widget -->
          <!-- TradingView Widget BEGIN -->
          <div class="tradingview-widget-container">
              <div class="tradingview-widget-container__widget"></div>
              <script type="text/javascript" src="https://s3.tradingview.com/external-embedding/embed-widget-events.js" async>
              {
              "colorTheme": "light",
              "isTransparent": false,
              "width": "100%",
              "height": "600",
              "locale": "en",
              "importanceFilter": "0,1",
              "currencyFilter": "USD"
            }
              </script>
          </div>
            <!-- TradingView Widget END -->
        </div>
    
        <div class="valuePortfolio">
          <div class="header-buttons">
            <h1> Value Portfolio </h1>
            <button class="buy-button">Buy</button>
            <button class="sell-button">Sell</button>
          </div>
          <!-- Value Portfolio Widget-->
          <!-- TradingView Widget BEGIN -->
          <div class="tradingview-widget-container">
            <div class="tradingview-widget-container__widget"></div>
            <script type="text/javascript" src="https://s3.tradingview.com/external-embedding/embed-widget-market-quotes.js" async>
            {
            "width": "100%",
            "height": "700",
            "symbolsGroups": [
              {
                "name": "Value Portfolio",
                "originalName": "Forex",
                "symbols": [
                  {
                    "name": "NASDAQ:ADBE",
                    "displayName": "Adobe Inc."
                  },
                  {
                    "name": "NYSE:ALB",
                    "displayName": "Albemarle Corporation"
                  },
                  {
                    "name": "CAPITALCOM:APLE",
                    "displayName": "Apple Hospitatlity REIT Inc."
                  },
                  {
                    "name": "NYSE:BP",
                    "displayName": "BP P.L.C."
                  },
                  {
                    "name": "NASDAQ:CSCO",
                    "displayName": "Cisco Systems Inc."
                  },
                  {
                    "name": "NASDAQ:COST",
                    "displayName": "Costco Wholesale Corporation"
                  },
                  {
                    "name": "NYSE:FCX",
                    "displayName": "Freeport-McMoran Inc."
                  },
                  {
                    "name": "NYSE:JPM",
                    "displayName": "JPMorgan Chase & Co."
                  },
                  {
                    "name": "NASDAQ:LIN",
                    "displayName": "Linde PLC"
                  },
                  {
                    "name": "NYSE:LLY",
                    "displayName": "Eli Lilly and Company"
                  },
                  {
                    "name": "NYSE:LOW",
                    "displayName": "Lowe's Companies Inc."
                  },
                  {
                    "name": "NASDAQ:MMSI",
                    "displayName": "Merit Medical Systems Inc."
                  },
                  {
                    "name": "CAPITALCOM:PSA",
                    "displayName": "Public Storage"
                  },
                  {
                    "name": "NYSE:TSM",
                    "displayName": "Taiwan Semiconductor Manufacturing Co. Ltd."
                  },
                  {
                    "name": "NYSE:TRGP",
                    "displayName": "Targa Resources Corp."
                  },
                  {
                    "name": "NYSE:TGT",
                    "displayName": "Target Corporation"
                  },
                  {
                    "name": "NYSE:KO",
                    "displayName": "The Coca-Cola Company"
                  },
                  {
                    "name": "NYSE:DIS",
                    "displayName": "The Walt Disney Company"
                  }
                ]
              }
            ],
            "showSymbolLogo": true,
            "colorTheme": "light",
            "isTransparent": false,
            "locale": "en"
          }
            </script>
          </div>
          <!-- TradingView Widget END -->
        </div>
    
        <div class="topStories">
          
          <!-- News Stories Widget -->
          <!-- TradingView Widget BEGIN -->
          <div class="tradingview-widget-container">
            <div class="tradingview-widget-container__widget"></div>
            <script type="text/javascript" src="https://s3.tradingview.com/external-embedding/embed-widget-timeline.js" async>
            {
            "feedMode": "market",
            "market": "stock",
            "colorTheme": "light",
            "isTransparent": false,
            "displayMode": "regular",
            "width": "100%",
            "height": "700",
            "locale": "en"
          }
            </script>
          </div>
          <!-- TradingView Widget END -->
        </div>
    
        
      </div>
     
    <h2>Annual Reports</h2>
    <nav1>
        <!--Source for opening it in a new tab https://stackoverflow.com/questions/33893728/how-to-open-navigation-link-in-new-tab-html5 -->
        <a href="../resources/anual_report_2023.pdf" name="anualReportButton" target="_blank">2023 Annual Report</a>
    </nav1>
    <footer>
        <p class="college">Concordia College</p><br />
        <p class="address">901 8th St S, Moorhead, Minnesota 56562</p>
        <nav>
            <a href="login.php" class="manager-LOGIN-link" >Manager Login</a>
        </nav>
    </footer>

    <div id="modal" class="modal">
      <div class="modal-content">
          <span class="close-button">&times;</span>
          <h3>Enter Trade Details</h3>
          <label for="ticker-symbol">Ticker Symbol:</label>
          <input type="text" id="ticker-symbol" name="ticker-symbol"><br><br>
          <label for="exchange">Exchange:</label>
          <select id="exchange" name="exchange">
              <option value="NYSE">NYSE</option>
              <option value="NASDAQ">NASDAQ</option>
          </select>
          <br><br>
          <button id="submit-button">Submit</button>
      </div>
  </div>
  


    <script>
      function checkPermissions() {
          console.log(permission);
        if (permission === "true") {
          return true;
        } else {
          return false;
        }
        
      }

      function showButtonsIfPermitted() {
        if (checkPermissions()) {
          var buyButtons = document.querySelectorAll('.buy-button');
          var sellButtons = document.querySelectorAll('.sell-button');

          buyButtons.forEach(button => button.style.display = 'flex');
          sellButtons.forEach(button => button.style.display = 'flex');
        }
      }



      // Get the modal
        var modal = document.getElementById("modal");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close-button")[0];

        // When the user clicks the button, open the modal 
        document.querySelectorAll('.buy-button, .sell-button').forEach(button => {
            button.addEventListener('click', () => {
                modal.style.display = "block";
            });
        });

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }

        // Add event listener for the submit button
        document.getElementById("submit-button").addEventListener('click', function() {
            // Handle the submission logic here
            modal.style.display = "none";
        });

        showButtonsIfPermitted();
      </script>
</body>
</html>