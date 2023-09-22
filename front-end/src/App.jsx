import { useState } from "react";
import "./App.css";
import axios from 'axios';

function App() {

  const [orderDetails, setOrderDetails] = useState({
    "totalAmount": {
      "currency": "EUR",
      "amount": "190.00"
    },
    "consumer": {
      "surname": "",
      "givenNames": "",
      "phoneNumber": "",
      "email": ""
    },
    "billing": {
      "phoneNumber": "",
      "countryCode": "",
      "name": "",
      "postcode": "",
      "suburb": "",
      "line1": ""
    },
    "shipping": {
      "phoneNumber": "0400000000",
      "countryCode": "IT",
      "name": "Joe Consumer",
      "postcode": "50056",
      "suburb": "Montelupo Fiorentino",
      "line1": "Via della Rosa, 58"
    },
    "merchant": {
      "redirectCancelUrl": "https://portal.integration.scalapay.com/failure-url",
      "redirectConfirmUrl": "https://portal.integration.scalapay.com/success-url"
    },
    "shippingAmount": {
      "currency": "EUR",
      "amount": "10.00"
    },
    "taxAmount": {
      "currency": "EUR",
      "amount": "3.70"
    },
    "type": "link",
    "product": "pay-in-3",
    "frequency": {
      "number": 1,
      "frequencyType": "monthly"
    },
    "orderExpiryMilliseconds": 600000,
    "extensions": {
      "type": {
        "link": {
          "notification": {
            "phoneCountryCode": "+39",
            "preferredLanguage": "italiano",
            "phoneNumber": "3401340340",
            "channels": [
              "sms"
            ]
          }
        }
      }
    },
    "discounts": [
      {
        "amount": {
          "currency": "EUR",
          "amount": "3.00"
        },
        "displayName": "10% Off"
      }
    ],
    "items": [
      {
        "price": {
          "currency": "EUR",
          "amount": "10.00"
        },
        "quantity": 1,
        "gtin": "123458791330",
        "name": "T-Shirt",
        "category": "clothes",
        "sku": "12341234",
        "brand": "TopChoice",
        "pageUrl": "https://www.scalapay.com//product/view/",
        "imageUrl": "https://www.scalapay.com//product/view/"
      }
    ]
  });


  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setOrderDetails({
      ...orderDetails,
      [name]: value,
    });
  };

  const handleSubmit = async () => {
    console.log(orderDetails);
    try {
      // POST request to Backend API
      const response = await axios.post('http://localhost:8080/api/orders', orderDetails);
      console.log(response);

      // Get checkoutUrl from response data
      const checkoutUrl = response.data.checkoutUrl;

      // Redirect to CheckoutPages
      window.location.href = checkoutUrl;
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <>
      <div>
        <label>Billing Information</label> <br />
        <input
          type="text"
          name="billing.phoneNumber"
          defaultValue={orderDetails.billing.phoneNumber}
          onChange={handleInputChange}
          placeholder="Phone Number"
        /> <br />
        <input
          type="text"
          name="billing.countryCode"
          defaultValue={orderDetails.billing.countryCode}
          onChange={handleInputChange}
          placeholder="Country Code"
        /> <br />
        <input
          type="email"
          name="billing.name"
          defaultValue={orderDetails.billing.name}
          onChange={handleInputChange}
          placeholder="Name"
        /><br />
        <input
          type="email"
          name="billing.postcode"
          defaultValue={orderDetails.billing.postcode}
          onChange={handleInputChange}
          placeholder="Post Code"
        /><br />
        <input
          type="email"
          name="billing.suburb"
          defaultValue={orderDetails.billing.suburb}
          onChange={handleInputChange}
          placeholder="Suburb"
        /><br />
        <input
          type="email"
          name="billing.line1"
          defaultValue={orderDetails.billing.line1}
          onChange={handleInputChange}
          placeholder="Line"
        /><br />

        <label>Consumer Information</label><br />
        <input
          type="text"
          name="consumer.surname"
          defaultValue={orderDetails.consumer.surname}
          onChange={handleInputChange}
          placeholder="Surname"
        /><br />
        <input
          type="text"
          name="consumer.givenNames"
          defaultValue={orderDetails.consumer.givenNames}
          onChange={handleInputChange}
          placeholder="GivenNames"
        /><br />
        <input
          type="text"
          name="consumer.phoneNumber"
          defaultValue={orderDetails.consumer.phoneNumber}
          onChange={handleInputChange}
          placeholder="Phone Number"
        /><br />
        <input
          type="email"
          name="consumer.email"
          defaultValue={orderDetails.consumer.email}
          onChange={handleInputChange}
          placeholder="Email"
        /><br />

        <button onClick={handleSubmit}>Create Order</button>
      </div>
    </>
  );
}

export default App;
