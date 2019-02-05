import React, {Component} from 'react';
import {Platform,   
  StyleSheet, 
  Text, 
  View, 
  ScrollView, 
  TouchableOpacity,
  Button 
} from 'react-native';

  
type Props = {};

export default class Main extends Component<Props> {
    render() {
      return (
        <View style={styles.container}>
          <View style={styles.header}>
            <Text style={styles.headerText}>TEST</Text>
          </View>
        <ScrollView style={styles.scrollContainer}>

        </ScrollView>
      
        <TouchableOpacity style={styles.addButton}>
            <Text style={styles.addButtonText}>+</Text>
        </TouchableOpacity>

        </View> 
      );
    }
  }
  
  const styles = StyleSheet.create({
    container: {
      justifyContent: 'center',
      marginTop: 50,
      padding: 20,
      backgroundColor: '#ffffff',
    },
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
      fontSize: 25,
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
  