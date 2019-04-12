const mongoose = require('mongoose');
const { table } = require('table');
mongoose.connect('mongodb://localhost:27017/FlowerSeller', { useNewUrlParser: true });
// FERI HELP!
const buys = mongoose.model('buys', {
  payment_method: String,
  amount: String,
  product: Array
});
const certificate = mongoose.model('certificate', {
  cert_id: String,
  cert_origin: String
});
const plants = mongoose.model('plants', {
  name: String,
  color: String,
  leaves: String,
  origin: String
});
const users = mongoose.model('users', {
  firstName: String,
  lastName: String,
  age: String,
  IDNumber: String
});
const Feedback = mongoose.model('feedback', {
  time: String,
  text: String,
  author: String
},
'feedback'
);
Feedback.find().then(kisferi => {
  // console.log(kisferi);
  const usersForTable = [];
  kisferi.forEach(user => {
    usersForTable.push([
      user.time,
      user.text,
      user.author
    ]);
  });
const feedback = new Feedback({text:'z'})
console.log(feedback);
feedback.save().then(() => console.log("faaaaa"));

  console.log(table(usersForTable));
  process.exit();
}).catch(err => console.log(err));

