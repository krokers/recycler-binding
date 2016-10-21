# recycler-binding
Android data binding adapters for RecyclerView. This library let's you bind RecyclerView items directly from xml layout files while
keeping your view models clean and tidy. 

## Download

Library is distributed via jcenter repository. To include in your project, simply add dependency:
```groovy
compile 'eu.rampsoftware:recycler-binding:0.1.1'
```

## How to use
#### Prepare ViewModel for your item:
```java
public class ItemViewModel extends BaseObservable {
    private final String mTitle;

    public ItemViewModel(String title) {
        mTitle = title;
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }
}
```
Contains data that you would like to display on each single item of the list.

#### Prepare ViewModel for your main screen
```java
public class MainActivityViewModel extends BaseObservable {

    private ObservableList<ItemViewModel> mItems = new ObservableArrayList<>();

    public MainActivityViewModel() {
        initializeModel();
    }
    
    public ObservableList<ItemViewModel> getItems() {
        return mItems;
    }

    public int getItemBindingId() {
        return BR.model;
    }
}
```
Contains collection of items to be displayed on your list. In addition, you have to provide information with 
name of your binding variable used in layout item. See below.

#### Create ViewModel representing data for your list item:
```xml
 <!-- item_layout.xml -->
 <layout xmlns:android="http://schemas.android.com/apk/res/android">    
    <data>
        <variable
            name="model"
            type="eu.rampsoftware.recyclerbinding.demo.model.ItemViewModel"/>
    </data>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@{model.tag, default=Item}"/>
</layout>
 ```
#### Create your layour for your main screen, which include the RecyclerView:
```xml
 <!-- main_layout.xml -->
 <layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:bind="http://schemas.android.com/apk/res-auto">
    <data>
        <variable
            name="model"
            type="eu.rampsoftware.recyclerbinding.demo.model.MainActivityViewModel" />
    </data>
    <android.support.v7.widget.RecyclerView
        android:id="@+id/dashboard_challenge_section_list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:scrollbars="vertical"
        bind:itemBindingId="@{model.itemBindingId}"
        bind:itemLayout="@{@layout/item_layout}"
        bind:items="@{model.items}" />
  </layout>
```
Please, notice the additional bind attributes used in RecyclerView.
<li>bind:itemBindingId - let you define the name of binding variable used in your item layout (in our case it's BR.model).
<li>bind:itemLayout - layout definition of list item.
<li>bind:items - list of item view models that will be bound to the defined layout.

Additional attributes which can be used:
bind:headerBindingId, bind:headerLayout, bind:headerModel
            
#### Create Activity:
```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.main_layout);
        binding.setVariable(BR.model, new MainActivityViewModel());
    }
}
```
As you can see, no additional binding code in the Activity is needed.

For more details, please see the included demo application.

# License

	Copyright 2016 Rafal Swierkot
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
