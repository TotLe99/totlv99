const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

const ROW = 16;
const COL = 10;
const SQ = 40;
const COLOR = "WHITE";
let score = 0;

function drawSquare(x, y, color) {
    ctx.fillStyle = color;
    ctx.fillRect(x * SQ, y * SQ, SQ, SQ);

    ctx.strokeStyle = "#f2f2f2";
    ctx.strokeRect(x * SQ, y * SQ, SQ, SQ);
}

let board = [];
for (let r = 0; r < ROW; r++) {
    board[r] = [];
    for (let c = 0; c < COL; c++) {
        board[r][c] = COLOR;
    }
}

console.log(board);

function drawBoard() {
    for (let r = 0; r < ROW; r++) {
        for (let c = 0; c < COL; c++) {
            drawSquare(c, r, board[r][c]);
        }
    }
}

drawBoard();

class Piece {
    tetromino;
    color;

    constructor(tetromino, color) {
        this.tetromino = tetromino;
        this.color = color;

        this.tetrominoN = 0;
        this.activeTetromino = this.tetromino[this.tetrominoN];

        this.x = 3;
        this.y = -2;
    }

    fill(color) {
        for (let r = 0; r < this.activeTetromino.length; r++) {
            for (let c = 0; c < this.activeTetromino.length; c++) {
                if (this.activeTetromino[r][c]) {
                    drawSquare(this.x + c, this.y + r, color);
                }
            }
        }
    }

    draw() {
        this.fill(this.color);
    }

    unDraw() {
        this.fill(COLOR);
    }

    moveDown() {


        if (!this.collision(0, 1, this.activeTetromino)) {
            this.unDraw();
            this.y++;
            this.draw();
        } else {
            this.lock();
            p = randomPiece();
        }
    }

    moveLeft() {
        if (!this.collision(-1, 0, this.activeTetromino)) {
            this.unDraw();
            this.x--;
            this.draw();
        }
    }

    moveRight() {
        if (!this.collision(1, 0, this.activeTetromino)) {
            this.unDraw();
            this.x++;
            this.draw();
        }
    }

    lock() {
        for (let r = 0; r < this.activeTetromino.length; r++) {
            for (let c = 0; c < this.activeTetromino.length; c++) {
                if (!this.activeTetromino[r][c]) {
                    continue;
                }

                if (this.y + r < 0) {
                    alert('GAME OVER!');
                    gameOver = true;
                    break;
                }

                board[this.y + r][this.x + c] = this.color; //chạm vào vật thì ngừng
            }
        }
        //xử lý ăn điểm
        for (let r = 0; r < ROW; r++) {
            let isFull = true;
            for (let c = 0; c < COL; c++) {
                isFull = isFull && (board[r][c] != COLOR);
            }

            if (isFull) {
                for (let i = r; i > 1; i--) {
                    for (let c = 0; c < COL; c++) {
                        board[i][c] = board[i - 1][c]
                    }
                }

                for (let c = 0; c < COL; c++) {
                    board[0][c] = COLOR;
                }

                score += 10;
            }
        }

        drawBoard();

        document.querySelector('#score').innerText = score;
    }

    rotate() {
        let nextPattern = this.tetromino[(this.tetrominoN + 1) % this.tetromino.length];
        let move = 0;

        if (this.collision(0, 0, nextPattern)) {
            if (this.x > COL / 2) {
                move = -1;
            } else {
                move = 1;
            }
        }

        if (!this.collision(0, 0, nextPattern)) {
            this.unDraw();
            this.x += move;
            this.tetrominoN = (this.tetrominoN + 1) % this.tetromino.length;
            this.activeTetromino = this.tetromino[this.tetrominoN];
            this.draw();
        }
    }

    collision(x, y, piece) {
        for (let i = 0; i < piece.length; i++) {
            for (let j = 0; j < piece.length; j++) {
                if (!piece[i][j]) {
                    continue;
                }

                let newX = this.x + j + x;
                let newY = this.y + i + y;

                if (newX < 0 || newX >= COL || newY >= ROW) {
                    return true;
                }

                if (newY < 0) {
                    continue;
                }

                if (board[newY][newX] != COLOR) {
                    return true;
                }
            }
        }
        return false;
    }
}

const PIECES = [[Z, "red"], [S, "green"], [T, "yellow"], [O, "blue"], [L, "purple"], [I, "cyan"], [J, "orange"]];

function randomColorsPIECES() {
    return PIECES.map(piece => {
        return [piece[0], '#' + Math.floor(Math.random() * 16777215).toString(16)];
    });
}

function randomPiece() {
    let r = Math.floor(Math.random() * PIECES.length);
    return new Piece(PIECES[r][0], PIECES[r][1]);
}

let p = randomPiece();
console.log(p);

document.addEventListener('keydown', function (e) {
    if (e.keyCode == 65) {
        p.moveLeft();
    } else if (e.keyCode == 68) {
        p.moveRight();
    } else if (e.keyCode == 32) {
        p.rotate();
    } else if (e.keyCode == 83) {
        p.moveDown();
    }
})

let gameOver = false;
let interval;
let time = 1000;

function drop() {
    interval = setInterval(function () {
        if (score >= 10) {
            console.log(time)
            time = 800;
            clearInterval(interval);
            drop();
        }
        if (!gameOver) {
            p.moveDown();
        } else {
            clearInterval(interval);
        }
    }, time);
}

drop();