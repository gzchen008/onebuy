$(function(){
   setSize();
});

function setSize(){
    setBodySize();
}

function setBodySize(){
    document.documentElement.style.height = window.innerHeight + 'px';
}