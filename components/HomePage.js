import React, {Component} from 'react';
import {StyleSheet, Text, View, ScrollView, TouchableOpacity} from 'react-native';
import {createAppContainer, createStackNavigator} from 'react-navigation'
import AddFormPage from './AddFormPage'

type Props = {};

class HomePage extends Component<Props> {
    render() {
      return (
        <View style={styles.container}>
        <ScrollView style={styles.scrollContainer}>

        </ScrollView>
      
        <TouchableOpacity 
          style={styles.addButton}
          onPress = {() => this.props.navigation.navigate('Add')}>
            <Text style={styles.addButtonText}>+</Text>
        </TouchableOpacity>

        </View> 
      );
    }
  }

const RootStack = createStackNavigator({
      Home: {
        screen: HomePage,
      },
      Add: {
        screen: AddFormPage,
      },
    },
    {
      initialRouteName: 'Home',

      defaultNavigationOptions: {
        headerStyle: {
          backgroundColor: '#DB3B3B',
        },
        headerTintColor: '#fff',
        headerTitleStyle: {
          fontWeight: 'bold',
        },
      },
    },
  );

const AppContainer = createAppContainer(RootStack);

export default class App extends React.Component {
    render() {
      return <AppContainer />;
    }
  }
  
const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#FFFFFF'
    },
    header: {
      backgroundColor: '#DB3B3B',
      alignItems: 'center',
      justifyContent:'center',
      borderBottomWidth: 10,
      borderBottomColor: '#ddd'
    },
    scrollContainer: {
      flex: 1,
      marginBottom: 100
    },
    headerText: {
      color: 'white',
      fontSize: 30,
      padding: 20
    },
    addButton: {
      position: 'absolute',
      zIndex: 15,
      right: 15,
      bottom: 20,
      backgroundColor: '#DB3B3B',
      width: 70,
      height: 70,
      borderRadius: 35,
      alignItems: 'center',
      justifyContent: 'center',
      elevation: 5
  },
    addButtonText: {
      color: '#fff',
      fontSize: 29
  }
});