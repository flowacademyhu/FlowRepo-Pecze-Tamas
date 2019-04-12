const mongoose = require('mongoose');
const { table } = require('table');
mongoose.connect('mongodb://localhost:27017/Epsilon', { useNewUrlParser: true });

const User = mongoose.model('User', {
  firstName: String,
  lastName: String,
  type: String,
  drinks: Array
});

User.find().then(users => {
  const usersForTable = [];
  users.forEach(user => {
    usersForTable.push([
      user.firstName,
      user.lastName,
      user.type,
      user.drinks.join(', ')
    ]);
  });
  console.log(table(usersForTable));
  process.exit();
});
