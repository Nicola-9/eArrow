<!DOCTYPE html>
<html>
    <head>
        <title>eArrow</title>
        <link rel="stylesheet" type="text/css" href="..//css/navStyle.css">
        <meta name ="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" 
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

    </head>
    <body>
        <nav>
        <header class="header-clearfix">
        	<a href="" class="header-mobile">
        		<span></span>
        		<span></span>
        		<span></span>
        	</a>
        </header>
        
            <div class="menu">
                <ul>
                    <li><a href="navbar." class="img"><img src = '..//image/eArrow.png' width="50" height="50"></a></li>
                    <li><a href="#" class="menu-item">Archi</a></li>
                    <li><a href="#" class="menu-item">Accessori Arco</a></li>
                    <li><a href="#" class="menu-item">Accessori Arciere</a></li>
                    <li><a href="#" class="menu-item">Frecce e Componenti</a></li>
                    <li><a href="#" class="menu-item">Paglioni e Bersagli</a></li>
                    <li><a href="#" id="search" class="search-icon"><i class="fa fa-search"></i></a></li>
                    <li><a href="#" id="user-account" class="menu-item"><i class="fa fa-user"></i></a></li>
                    <li><a href="#" id="shopping-cart" class="menu-item"><i class="fa fa-shopping-basket"></i></a></li>
                </ul>
                <div class="search-form">
                    <form>
                        <input type="text" name="" placeholder="eArrow.it">
                    </form>
                </div>
                <a class="close"><i class="fa fa-times"></i></a>
            </div>
        </nav>
        <script src="https://code.jquery.com/jquery-3.4.1.js"   integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="   
        crossorigin="anonymous"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('#search').click(function(){
                    $('.menu-item').addClass('hide-item')
                    $('.search-form').addClass('active')
                    $('.close').addClass('active')
                    $('#search').hide()
                })
                $('.close').click(function(){
                    $('.menu-item').removeClass('hide-item')
                    $('.search-form').removeClass('active')
                    $('.close').removeClass('active')
                    $('#search').show()
                })
            })
        </script>
</html>