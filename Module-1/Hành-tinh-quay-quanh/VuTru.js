function createStars() {
    const container = document.querySelector('.container');
    for (let i = 0; i < 1000; i++) {
        const star = document.createElement('div');
        star.className = 'star';
        star.style.width = '.4px';
        star.style.height = '.4px';
        star.style.top = Math.random() * 100 + '%';
        star.style.left = Math.random() * 100 + '%';
        container.appendChild(star);
    }
}
createStars();