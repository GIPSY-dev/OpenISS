'use strict';

const soap = require('soap');
const url = 'http://localhost:9090/openiss?wsdl';

exports.getFrame = function(args, cb) {
    soap.createClient(url, function(err, client) {
        if (err) {
            cb(err, "soap", "");
        }
        else {
            client.getFrame(args, function(err, result) {
                cb(err, "soap", result.return);
            });
        }
    });
}

exports.mixFrame = function(args, cb) {
    soap.createClient(url, function(err, client) {
        if (err) {
            cb(err, "soap", "");
        }
        else {
            client.mixFrame(args, function(err, result) {
                cb(err, "soap", result.return);
            });
        }
    });
}