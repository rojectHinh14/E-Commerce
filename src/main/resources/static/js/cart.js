const body = document.querySelector('body');
document.querySelector(".cart #inCart").addEventListener('click', function(){
    body.classList.toggle('show-cart');
})

const close_btn = document.querySelector('.btn .close');
close_btn.addEventListener('click', function(){
    body.classList.toggle('show-cart');
})