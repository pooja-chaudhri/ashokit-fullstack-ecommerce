export class PaymentCallback {


    constructor(
        public razorpayOrderId:string,
        public razorpayPaymentId:string,
        public razorpaySignature: string
    ){
        
    }
}
