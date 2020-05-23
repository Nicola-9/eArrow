<!-- Swiper -->
<div class="swiper-container">
	<div class="swiper-wrapper">
		
		<div class="swiper-slide">
			<img src="..//image/testImageSliderBig.jpg">
		</div>
		
    	<div class="swiper-slide">
    		<img src="..//image/testImageSliderBig.jpg">
    	</div>
		
		<div class="swiper-slide">
			<img src="..//image/testImageSliderBig.jpg">
		</div>
	</div>
		    <!-- Add Pagination -->
	<div class="swiper-pagination"></div>

</div>
		  
	<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>
		
		<script>
		    var swiper = new Swiper('.swiper-container', {
		      effect: 'coverflow',
		      grabCursor: true,
		      centeredSlides: true,
		      slidesPerView: 'auto',
		      coverflowEffect: {
		        rotate: 35,
		        stretch: 0,
		        depth: 300,
		        modifier: 1,
		        slideShadows : true,
		      },
		     
		      loop: true,
		      
		      autoplay: {
		          delay: 5000,
		          disableOnInteraction: true,
		        },
		        
		      pagination: {
		          el: '.swiper-pagination',
		          clickable: true,
		          dynamicBullets: false,
		          
		      },
		    });
	 </script>