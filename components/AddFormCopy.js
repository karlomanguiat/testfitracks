import React, { Component } from 'react';
import {Platform,   
    StyleSheet, 
    Text, 
    View, 
    ScrollView, 
    TouchableOpacity,
    Button 
  } from 'react-native';

import t from 'tcomb-form-native';

const Form = t.form.Form;

const User = t.struct({
  container: t.String,
  username: t.maybe(t.String),
  password: t.String,
  terms: t.Boolean
});

const formStyles = { ...Form.stylesheet,
  formGroup: {
        normal: {
        marginBottom: 10
    },
  },
  controlLabel: {
    normal: {
      color: 'blue',
      fontSize: 18,
      marginBottom: 7,
      fontWeight: '600'
    },
    // the style applied when a validation error occours
    error: {
      color: 'red',
      fontSize: 18,
      marginBottom: 7,
      fontWeight: '600'
    }
  }
}

const options = {
  fields: {
    email: {
      error: 'Without an email address how are you going to reset your password when you forget it?'
    },
    password: {
      error: 'Choose something you use on a dozen other sites or something you won\'t remember'
    },
    terms: {
      label: 'Agree to Terms',
    },
  },
  stylesheet: formStyles,
};

type Props = {};
export default class AddForm extends Component<Props> {
  handleSubmit = () => {
    const value = this._form.getValue();
    console.log('value: ', value);
    }
    
  render() {
    return (
      <View style={styles.container}>
        <View style={styles.header}>
            <Text style={styles.headerText}>TEST</Text>
        </View>
        <ScrollView style={styles.scrollContainer}>
            <Form 
                ref={c => this._form = c}
                type={User} 
                options={options}
            />
            <Button
                title="Sign Up!"
                onPress={this.handleSubmit}
            />
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
