4. Imagine you’re updating the payment feature in a monolithic shopping app. Describe in 3-4 sentences how this update
   could impact other features, compared to making the same update in a microservices-based app like Flipkart.
   <br><br><em><strong>Hint:</strong> Think about deployment, downtime, and risk to unrelated features.</em>

Ans.
    In a monolithic shopping app, updating the payment feature may require redeploying the entire application, 
    which can cause downtime and affect features such as login, product browsing, and order management. 
    A bug in the payment update could also impact unrelated features. In a microservices-based app like Flipkart, 
    the Payment Service can be updated and deployed independently without redeploying the entire application. This reduces 
    downtime and the risk of affecting other services, although payment-related failures can still affect checkout.   
