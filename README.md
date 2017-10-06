# RealmMvp
Example android project using mvp architecture and with realm async listeners

There are a lot of articles on blogs and content websites like medium regarding the MVP architecture on android. Each one has their own way of implementing the M, V and P in the MVP architecture. After reading so many articles, I am just trying to put it in a not-so-technical way. I think the crux of MVP lies just in the following few statements :

1) A model is anything which directly interacts with data - this can be your database models, your POJOs which may represent a state which can further be saved into disk - can also be the service layers which talk with your servers and get new data

2) A view is a dummy being which does not know anything about what to do with a user input; it's there just to show android.view and pass any action to presenter. Much like setting data on a adapter, setting a android.view visible or gone etc.

3) A presenter - something which connects your dummy views to the data - it's this object which is responsible for what to do with a user click - it's this object which knows when to request service for new data - it's this object which knows when to modify an existing data and call back the view to update itself etc.
### Some Notes
**A presenter should never ever know about anything related to android specific classes (eg: context, fragment)**

>Think about it in terms of a use case--we want to move to a new activity(HomeActivity) on press of a button click from other activity(LoginActivity)

>in a non MVP way-- we can just attach an onclicklistener to the button in login activity and use startActivity(LoginActivity.this,HomeActivity.class) in it's onclick call back; basically just LoginActivity-->HomeActivity

>in a MVP way (the way i understood it is), on clicking the button you tell the LoginPresenter that the button is clicked; presenter then decides what to do with this click; since it involves using "startActivity" presenter again tells view to move to the HomeActivity. So basically, two jumps between - LoginActivity-->LoginPresenter-->LoginActivity-->HomeActivity

>bit of a jumping around but this is how it is.

**The only thing that the view will do is calling a method from the presenter every time there is an interface action (a button click for example)**

>No getData() method calls on presenter. Usually the methods to make presenter aware of lifecycle callbacks.

**A view should never ever know anything about how the data is stored - never ever modifies the data - never know anything about the network activity**

>A non MVP way of fetching data from server -- SomeButtonClickInFragment-->NetworkCall-->NetworkCallbackWithData-->UpdateUI

>A MVP way of doing the same-- SomeButtonClickInFragment-->ThisFragmentPresenter-->DataRepository-->NetworkCall-->NetworkCallbackWithData-->UpdatePresenterData-->UpdateUI

**Usually a contract (interface) is made between a view and it's presenter**

>This just makes things more interesting as a presenter can be changed without changing anything in it's view or vice versa.(#CodeToAnInterface)

**A single presenter per view, Singleton or non-singleton DataRepository(it's our choice really)**

>Singleton will just make data repository bloated if we have a "real world" application with couple of Models.

### About This Example
The associated example works with this points in mind. It's a simple app which shows a list of Books and you can also add a new book. This project is made on Android Studio 3.0 Beta 2, so there may be some problem running it on older version of Android Studio.

#### Commit 6436bfd
This is the commit where a basic MVP architectured app is in place. It uses minimum third party libs to make things simple to understand.

#### Commit c880e9d
This is the commit where butterknife library is introduced in the project. The core structure and functionality of the app remains the same.

#### Commit 2c823ee
This adds support of dagger2 library for dependency injection.
