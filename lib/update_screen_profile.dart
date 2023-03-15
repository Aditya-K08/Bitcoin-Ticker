import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
class UpdateProfileScreen extends StatelessWidget {
   UpdateProfileScreen({Key? key}) : super(key: key);

  final TextEditingController name= TextEditingController();
  final TextEditingController email = TextEditingController();

  Future<void> saveData (String key, String value) async{
    SharedPreferences _prefs= await SharedPreferences.getInstance();
    await _prefs.setString(key, value);
   }

  void saveUserDetails() async{
   // print(name.text);
   // print(email.text);
    await saveData('name', name.text);
    await saveData('email', email.text);
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Update Profile',),
      ),
      body: Column(
        children: [
          CustomTextField("Name",name),
          CustomTextField("Email",email),
          ElevatedButton(
              onPressed: (){
                saveUserDetails();
                Navigator.pop(context);
              },
              child: Text('Save')),
        ],
      ),
    );
  }
}
Widget CustomTextField(String title, TextEditingController controller){
  return Padding(
    padding: EdgeInsets.all(15.0),
    child: TextField(
      controller: controller,
      decoration: InputDecoration(
        border: OutlineInputBorder(),
        hintText: title,
      ),
    ),
  );
}