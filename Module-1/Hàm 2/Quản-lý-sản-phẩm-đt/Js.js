let arr = ['Sony Xperia', 'Samsung Galaxy', 'Nokia', 'Xiaomi Redmi Note 4', 'Apple iPhone 6S', 'Xiaomi Mi 5s Plus',
    'Apple iPhone 8 Plus', 'Fujitsu F-04E', 'Oppo A71']

function add() {
    let name = document.getElementById("name").value;

}

hienThi();

function hienThi() {
    let str = document.getElementById("str");
    for (let i = 0; i < arr.length; i++) {
        str.innerHTML = `<form>
    <table>
        <tr>
            <td>` + arr[0] + `</td>
            <td>
              <button type="button" onclick="">Edit </button>
            </td>
            <td>
                <button type="button" onclick="">Delete</button>
            </td>
        </tr>
        <tr>
            <td>` + arr[1] + `</td>
            <td>
                <button type="button" onclick="">Edit</button>
            </td>
            <td>
                <button type="button" onclick="">Delete</button>
            </td>
        </tr>
        <tr>
            <td>` + arr[2] + `</td>
            <td>
                <button type="button" onclick="">Edit</button>
            </td>
            <td>
                <button type="button" onclick="">Delete</button>
            </td>
        </tr>
        <tr>
            <td>` + arr[3] + `</td>
            <td>
                <button type="button" onclick="">Edit</button>
            </td>
            <td>
                <button type="button" onclick="">Delete</button>
            </td>
        </tr>
        <tr>
            <td>` + arr[3] + `</td>
            <td>
                <button type="button" onclick="">Edit</button>
            </td>
            <td>
                <button type="button" onclick="">Delete</button>
            </td>
        </tr>
        <tr>
            <td>` + arr[4] + `</td>
            <td>
                <button type="button" onclick="">Edit</button>
            </td>
            <td>
                <button type="button" onclick="">Delete</button>
            </td>
        </tr>
        <tr>
            <td>` + arr[5] + `</td>
            <td>
                <button type="button" onclick="">Edit</button>
            </td>
            <td>
                <button type="button" onclick="">Delete</button>
            </td>
        </tr>
        <tr>
            <td>` + arr[6] + `</td>
            <td>
                <button type="button" onclick="">Edit</button>
            </td>
            <td>
                <button type="button" onclick="">Delete</button>
            </td>
        </tr>
        <tr>
            <td>` + arr[7] + `</td>
            <td>
                <button type="button" onclick="">Edit</button>
            </td>
            <td>
                <button type="button" onclick="">Delete</button>
            </td>
        </tr>
    </table>
</form>`
    }
}