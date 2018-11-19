let GCM = require('node-gcm-ccs');
let gcm = new GCM('sender ID','server key')
gcm.on('message', (messageId, from, category, data) => {
    console.log('received message ', data);
})

gcm.on('receipt', (messageId, from, category, data) => {
    console.log('received receipt', data);
})


let client_token ='client device id'

gcm.send(client_token, {message: 'hello world'}, {delivery_receipt_requested: true}, (err, res) => {
    if (err) {
        console.error(err);
    } else {

    }
})
