const destinationImage = document.querySelector("#destination");
const clickButton = document.querySelector("#clickButton");
const submitButton = document.querySelector("#submitButton")
clickButton.addEventListener("click", pasteImage);
submitButton.addEventListener("click", sendImage);

let imageBlob = null;

async function pasteImage() {

    try {
        const permission = await navigator.permissions.query({
            name: "clipboard-read",
        });
        if (permission.state === "denied") {
            throw new Error("Not allowed to read clipboard.");
        }
        const clipboardContents = await navigator.clipboard.read();
        for (const item of clipboardContents) {
            if (!item.types.includes("image/png")) {
                throw new Error("Clipboard contains non-image data.");
            }
            imageBlob = await item.getType("image/png");
            destinationImage.src = URL.createObjectURL(imageBlob);
        }
    } catch (error) {
        console.error(error.message);
    }
}

function sendImage() {
    if (imageBlob) {
        const formData = new FormData();
        formData.append('imageFile', imageBlob);

        fetch('/uploadImage', {
            method: "POST",
            body: formData
        })
            .then(response => {
                console.log('success');
            })
            .catch(
                error => {
                    console.log('error');
                });
    }   else {
        console.log('no image');
    }
}